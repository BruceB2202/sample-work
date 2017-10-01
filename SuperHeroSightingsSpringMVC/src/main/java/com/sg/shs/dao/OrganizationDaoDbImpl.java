/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

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
public class OrganizationDaoDbImpl implements OrganizationDao {

    private JdbcTemplate jdbcTemplate;

    @Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public static final String SQL_INSERT_ORGANIZATION
            = "insert into organization"
            + "(organization_name, organization_description, organization_address, "
            + "organization_city, organization_state, organization_phone, organization_email)"
            + "values(?, ?, ?, ?, ?, ?, ?)";
    
    public static final String SQL_DELETE_ORGANIZATION
            = "delete from organization where organization_id = ?";
    
    public static final String SQL_DELETE_ORGANIZATION_HV
            = "delete from hero_villain_organization where organization_id = ?";
    
    public static final String SQL_SELECT_ORGANIZATION
            = "select * from organization where organization_id = ?";
    
    public static final String SQL_SELECT_ALL_ORGANIZATIONS
            = "select * from organization";
    
    public static final String SQL_UPDATE_ORGANIZATION
            = "update organization set "
            + "organization_name = ?, organization_description = ?, organization_address = ?, "
            + "organization_city = ?, organization_state = ?, organization_phone = ?, "
            + "organization_email = ? where organization_id = ?";
    
    private static final String SQL_SELECT_ALL_ORGS_FOR_HERO
            = "select org.organization_id, org.organization_name, org.organization_description, org.organization_address, org.organization_city, org.organization_state, org.organization_phone, org.organization_email from organization org join hero_villain_organization hvo on org.organization_id = hvo.organization_id where hvo.hero_villain_id = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(Organization organization) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationAddress(),
                organization.getOrganizationCity(),
                organization.getOrganizationState(),
                organization.getOrganizationPhone(),
                organization.getOrganizationEmail());
        organization.setOrganizationId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public Organization getOrganization(int organizationId) {
        try{
        return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION, new OrganizationMapper(), organizationId);
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
    }

    @Override
    public void updateOrganization(Organization organization) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationAddress(),
                organization.getOrganizationCity(),
                organization.getOrganizationState(),
                organization.getOrganizationPhone(),
                organization.getOrganizationEmail(),
                organization.getOrganizationId());
    }

    @Override
    public void removeOrganization(int organizationId) {
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION_HV, organizationId);
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, organizationId);
    }

    @Override
    public List<Organization> getAllOrganizationsForHero(int heroVillainId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGS_FOR_HERO, new OrganizationMapper(), heroVillainId);
    }
    

    private static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int RowNum) throws SQLException {
            Organization newOrg = new Organization();
            newOrg.setOrganizationId(rs.getInt("organization_id"));
            newOrg.setOrganizationName(rs.getString("organization_name"));
            newOrg.setOrganizationDescription(rs.getString("organization_description"));
            newOrg.setOrganizationAddress(rs.getString("organization_address"));
            newOrg.setOrganizationCity(rs.getString("organization_city"));
            newOrg.setOrganizationState(rs.getString("organization_state"));
            newOrg.setOrganizationPhone(rs.getString("organization_phone"));
            newOrg.setOrganizationEmail(rs.getString("organization_email"));
            return newOrg;
        }
    }
}
