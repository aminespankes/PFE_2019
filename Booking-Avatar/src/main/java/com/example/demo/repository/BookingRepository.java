package com.example.demo.repository;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>  {
	Booking findByEmailuser(String emailuser);
	Booking findByEmailavatar(String emailavatar);

	//List<Booking> findByEmailuser(String emailuser);
	
	Booking findByActive(int active);
	Booking findByPayement(int payement);
	Booking deleteByemailuser (String emailuser);

	
	/*-----------------------avatar find----------------------------------------------------------------------------------------*/
	@Query("SELECT b1 FROM Booking b1 WHERE LOWER(b1.emailavatar) = LOWER(:emailavatar) and (b1.active=0) and (b1.payement=0) and LOWER(:date) <= (b1.date) ")
    public List<Booking> find1(@Param("emailavatar") String emailavatar,Date date);
	
	@Query("SELECT b2 FROM Booking b2 WHERE LOWER(b2.emailavatar) = LOWER(:emailavatar) and (b2.active=1) and (b2.payement=0) and LOWER(:date) <= (b2.date) ")
    public List<Booking> find2(@Param("emailavatar") String emailavatar,Date date);
	

	@Query("SELECT b5 FROM Booking b5 WHERE LOWER(b5.emailavatar) = LOWER(:emailavatar) and (b5.active=1)and (b5.payement=1) and LOWER(:date) <= (b5.date) ")
    public List<Booking> findacceptavatar(@Param("emailavatar") String emailavatar,Date date);
	
	
	@Query("SELECT count(*) FROM Booking nbreAva WHERE LOWER(nbreAva.emailavatar) = LOWER(:emailavatar) and (nbreAva.active=1)  ")
	public int countnbreAva(@Param("emailavatar") String emailavatar);
	
	@Query("SELECT a9 FROM Booking a9 WHERE LOWER(a9.emailavatar) = LOWER(:emailavatar) and (a9.active=1)and (a9.payement=1) and   LOWER(:date) > (a9.date) ")
    public List<Booking> findHistoriqueAvatar(@Param("emailavatar") String emailavatar,Date date);
	
	
	/*-----------------------user find-------------------------------------------------------------------------------------*/
	@Query("SELECT b FROM Booking b WHERE LOWER(b.emailuser) = LOWER(:emailuser) and (b.active=0) and (b.payement=0) and   LOWER(:date) <= (b.date)")
    public List<Booking> find(@Param("emailuser") String emailuser,Date date);
	
	
	@Query("SELECT b3 FROM Booking b3 WHERE LOWER(b3.emailuser) = LOWER(:emailuser) and (b3.active=1) and (b3.payement=0) ")
    public List<Booking> find3(@Param("emailuser") String emailuser);
	
	@Query("SELECT count(*) FROM Booking c WHERE LOWER(c.emailuser) = LOWER(:emailuser) and (c.active=1) and (c.payement=0) ")
	public int countnotif(@Param("emailuser") String emailuser);

	@Query("SELECT b4 FROM Booking b4 WHERE LOWER(b4.emailuser) = LOWER(:emailuser) and (b4.active=1)and (b4.payement=1) ")
    public List<Booking> findaccept(@Param("emailuser") String emailuser);
	
	@Query("SELECT b6 FROM Booking b6 WHERE LOWER(b6.emailuser) = LOWER(:emailuser) and (b6.active=1)and (b6.payement=1) and   LOWER(:date) <= (b6.date) ")
    public List<Booking> findAccepted(@Param("emailuser") String emailuser,Date date);
	

	@Query("SELECT id FROM Booking idd WHERE LOWER(idd.emailuser) = LOWER(:emailuser) and (idd.active=1) and (idd.payement=0)")
    
	public List<Integer> boo(@Param("emailuser") String emailuser);
	
	
	
	@Query("SELECT count(*) FROM Booking nbreAva1 WHERE LOWER(nbreAva1.emailuser) = LOWER(:emailuser) and (nbreAva1.active=1)  ")
	public int countnbreAva1(@Param("emailuser") String emailuser);
	
	@Query("SELECT b9 FROM Booking b9 WHERE LOWER(b9.emailuser) = LOWER(:emailuser) and (b9.active=1)and (b9.payement=1) and   LOWER(:date) > (b9.date) ")
    public List<Booking> findHistorique(@Param("emailuser") String emailuser,Date date);

	
@Query("SELECT id FROM Booking userbooking WHERE LOWER(userbooking.emailuser) = LOWER(:emailuser)  and (userbooking.payement!=0)")
    
	public List<Integer> countbookinguser(@Param("emailuser") String emailuser);
	
	
/*----------------finadmin-----------------------------------*/
	
	@Query("SELECT A1 FROM Booking A1 WHERE  (A1.active=1)and (A1.payement=1) ")
    public List<Booking> findAllAccepted();
	

}
