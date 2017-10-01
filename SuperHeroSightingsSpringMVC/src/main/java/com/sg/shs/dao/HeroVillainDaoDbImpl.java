/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.HeroVillain;
import com.sg.shs.model.Organization;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bruce_breslin
 */
public class HeroVillainDaoDbImpl implements HeroVillainDao {

    private JdbcTemplate jdbcTemplate;

    @Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_HV
            = "insert into hero_villain"
            + "(hero_villain_name, hero_villain_description, hero_villain_superpower)"
            + "values (?,?,?)";

    private static final String SQL_INSERT_HV_ORG
            = "insert into hero_villain_organization(hero_villain_id, organization_id)"
            + "values (?, ?)";

    private static final String SQL_DELETE_HV
            = "delete from hero_villain where hero_villain_id = ?";

    private static final String SQL_UPDATE_HV
            = "update hero_villain set "
            + "hero_villain_name = ?, hero_villain_description = ?, hero_villain_superpower = ? "
            + "where hero_villain_id = ?";

    private static final String SQL_SELECT_HV
            = "select * from hero_villain where hero_villain_id = ?";

    private static final String SQL_SELECT_ALL_HV
            = "select * from hero_villain";

    private static final String SQL_SELECT_ALL_HEROES_IN_ORG
            = "select * from hero_villain_organization where organization_id = ?";

    private static final String SQL_DELETE_HV_ORG
            = "delete from hero_villain_organization where hero_villain_id = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addHeroVillain(HeroVillain heroVillain) {
        jdbcTemplate.update(SQL_INSERT_HV,
                heroVillain.getHeroVillainName(),
                heroVillain.getHeroVillainDescription(),
                heroVillain.getHeroVillainPower());
        heroVillain.setHeroVillainId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        insertHeroVillainOrgs(heroVillain);
    }

    @Override
    public List<HeroVillain> getAllHeroVillains() {
        return jdbcTemplate.query(SQL_SELECT_ALL_HV, new HeroVillainMapper());
    }

    @Override
    public HeroVillain getHeroVillain(int hvId) {
        try {
            HeroVillain hV = jdbcTemplate.queryForObject(SQL_SELECT_HV, new HeroVillainMapper(), hvId);
            return hV;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateHeroVillain(HeroVillain heroVillain) {
        jdbcTemplate.update(SQL_UPDATE_HV,
                heroVillain.getHeroVillainName(),
                heroVillain.getHeroVillainDescription(),
                heroVillain.getHeroVillainPower(),
                heroVillain.getHeroVillainId());
        jdbcTemplate.update(SQL_DELETE_HV_ORG, heroVillain.getHeroVillainId());
        insertHeroVillainOrgs(heroVillain);
    }

    @Override
    public void removeHeroVillain(int hvId) {
        jdbcTemplate.update(SQL_DELETE_HV_ORG, hvId);
        jdbcTemplate.update(SQL_DELETE_HV, hvId);
    }

    @Override
    public List<HeroVillain> getAllMembersOfOrg(int orgId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_HEROES_IN_ORG, new HeroVillainMapper(), orgId);
    }

    private void insertHeroVillainOrgs(HeroVillain heroVillain) {
        final int heroVillainId = heroVillain.getHeroVillainId();
        final List<Organization> orgList = heroVillain.getHeroVillainOrganizations();

        for (Organization currentOrg : orgList) {
            jdbcTemplate.update(SQL_INSERT_HV_ORG,
                    heroVillainId,
                    currentOrg.getOrganizationId());
        }
    }

    private static final class HeroVillainMapper implements RowMapper<HeroVillain> {

        @Override
        public HeroVillain mapRow(ResultSet rs, int RowNum) throws SQLException {
            HeroVillain newHv = new HeroVillain();
            newHv.setHeroVillainId(rs.getInt("hero_villain_id"));
            newHv.setHeroVillainName(rs.getString("hero_villain_name"));
            newHv.setHeroVillainDescription(rs.getString("hero_villain_description"));
            newHv.setHeroVillainPower(rs.getString("hero_villain_superpower"));
            return newHv;
        }
    }
}
