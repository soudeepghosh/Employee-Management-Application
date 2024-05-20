package in.soudeep.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.soudeep.dataobjects.Employee;
import in.soudeep.util.HibernateUtil;

public class EmployeeDaoImpl implements IEmployeeDao {
	
	Session session = null;
	Transaction transaction = null;

	@Override
	public String insertRecord(Employee employee) {
		Boolean flag = false;
		String msg = "";
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				session.save(employee);
				flag = true;
			}
		} catch(HibernateException he) {
			System.out.println("Some thing went wrong");
			he.printStackTrace();
		} catch (Exception e) {
			System.out.println("Some thing went wrong");
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if(flag) {
					transaction.commit();
					msg = "success";
				} else {
					transaction.rollback();
					msg = "failure";
				}
			}
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	@Override
	public Employee readRecord(Integer eid) {
		Employee employee = null;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				employee = session.get(Employee.class, eid);
			}
			
		} catch(HibernateException he) {
			System.out.println("Some thing went wrong");
			he.printStackTrace();
		} catch (Exception e) {
			System.out.println("Some thing went wrong");
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}

	@Override
	public String updateRecord(Employee employee) {
		Boolean flag = false;
		String msg = "";
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				session.saveOrUpdate(employee);
				flag = true;
			}
		} catch(HibernateException he) {
			System.out.println("Some thing went wrong");
			he.printStackTrace();
		} catch (Exception e) {
			System.out.println("Some thing went wrong");
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if(flag) {
					transaction.commit();
					msg = "success";
				} else {
					transaction.rollback();
					msg = "failure";
				}
			}
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	@Override
	public String deleteRecord(Integer eid) {
		Boolean flag = false;
		String msg = "";
		Employee employee = null;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				employee = session.get(Employee.class, eid);
			}
			if (transaction != null) {
				if (employee != null) {
					session.delete(employee);;
					flag = true;
				}
			}
		} catch(HibernateException he) {
			System.out.println("Some thing went wrong");
			he.printStackTrace();
		} catch (Exception e) {
			System.out.println("Some thing went wrong");
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if(flag) {
					transaction.commit();
					msg = "success";
				} else {
					transaction.rollback();
					msg = "failure";
				}
			}
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

}
