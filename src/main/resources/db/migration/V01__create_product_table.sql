CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `iva` DECIMAL (10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `product` VALUES 
	(1,'PERMANENT RESIDENT VISAS','EB-1','for aliens with extraordinary ability, outstanding professors and researchers, or multinational business managers and executives.', 1500.00, 150.00),
	(2,'PERMANENT RESIDENT VISAS','EB-2','for aliens with exceptional ability or aliens with advanced degrees (employer/sponsor required)', 1500.00, 150.00),
    (3,'PERMANENT RESIDENT VISAS','EB-3','for professional workers (with university degree), skilled workers and unskilled workers (employer/sponsor required)', 1500.00, 150.00),
    (4,'PERMANENT RESIDENT VISAS','EB-4','for religious workers', 1500.00, 150.00),
    (5,'PERMANENT RESIDENT VISAS','EB-5','for aliens who invest $1 million and create 10 new full time jobs (in limited situations, an investment of $500,000 and the creation of 5 new jobs is acceptable).', 3000.00, 300.00),
    (6,'TEMPORARY VISAS','B-1/B-2','Visitor Visas, which permit a visitor to remain in the U.S. for up to six month (employment is not permitted).', 3000.00, 300.00),
    (7,'TEMPORARY VISAS','E-2','Treaty Investor Visas, which permit investors from certain countries to invest a substantial amount of money and acquire a controlling interest in an active U.S. business.  The visa is issued for up to five years and is renewable.  The investor can work in his or her own business.  The spouse can qualify for an unrestricted temporary work card.  Children up to the age of 21 can accompany the parents and attend school, but cannot work.', 1500.00, 150.00),
    (8,'TEMPORARY VISAS','F-1','Student Visas, which permit foreign students to attend U.S. educational institutions.  Limited employment is permitted in some cases.', 3000.00, 300.00),
    (9,'TEMPORARY VISAS','H-1B','Visas for Workers in Specialty Occupations, which permit employment of professional level workers by a sponsoring employer.  The visa is issued for up to three years and can be renewed another three years (additional renewals are possible in some cases).', 1500.00, 150.00),
    (10,'TEMPORARY VISAS','K-1','Visas for a Fiancé(e) of a U.S. citizen.', 1500.00, 150.00),
    (11,'TEMPORARY VISAS','K-3','Visas for a Spouse of a U.S. citizen.', 1500.00, 150.00),
    (12,'TEMPORARY VISAS','L-1','Visas for Multinational Managers, Executives and Specialized Knowledge employees who are being transferred to the U.S. by a related international company.', 3000.00, 300.00),
    (13,'TEMPORARY VISAS','O-1','Visas for Aliens with Extraordinary Ability who are seeking temporary employment.  This visa is issued for up to three years and can be renewed in one year increments.', 3000.00, 300.00),
    (14,'TEMPORARY VISAS','P-1','Visas for Internationally Recognized Entertainment Groups and Athletes.', 1500.00, 150.00),
    (15,'TEMPORARY VISAS','R-1','Visas for Religious Workers who are being transferred to the U.S. by a related international church.', 1500.00, 150.00),
    (16,'TEMPORARY VISAS','TN','Visas for certain professional workers from Mexico and Canada.  This visa is issued for one year and can be renewed in one year increments.', 3000.00, 300.00);

    