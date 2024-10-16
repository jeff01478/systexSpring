package com.systex.testJDBC.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TxProductService {

	@Autowired
	private ProductDao productDao;
	
	@Transactional(
			readOnly = false,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.DEFAULT,
			rollbackFor = {ALittleSeriousExecption.class}
			)
	public void testTx() throws ALittleSeriousExecption {
		Product p = productDao.getProduct(1);
		p.setName("eagle");
		productDao.update(p);
//		raiseException();
		troubleMaker();
	}

	private static void raiseException() {
		throw new RuntimeException();
	}
	
	private static void troubleMaker() throws ALittleSeriousExecption {
		throw new ALittleSeriousExecption("Oops...a liitle serious!!!");
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
