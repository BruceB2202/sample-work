USE HotelReservation;

SELECT ReservationID,
	SubTotal,
    Tax,
    GrandTotal,
    AddOnName
    
FROM Bill b

INNER
JOIN BillAddOn bao
ON b.BillID = bao.BillID

INNER
JOIN AddOn ao
ON bao.AddOnID = ao.AddOnID

WHERE b.ReservationID = 1;