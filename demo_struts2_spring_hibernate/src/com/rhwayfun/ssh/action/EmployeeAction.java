package com.rhwayfun.ssh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rhwayfun.ssh.form.AddEmpForm;
import com.rhwayfun.ssh.pojo.Department;
import com.rhwayfun.ssh.pojo.Employee;
import com.rhwayfun.ssh.service.DepartmentService;
import com.rhwayfun.ssh.service.EmployeeService;

public class EmployeeAction extends DispatchAction {

	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public ActionForward addEmpUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("addEmpUI");
	}
	
	//添加雇员
	public ActionForward addEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AddEmpForm addEmpForm = (AddEmpForm) form;
		
		//创建一个雇员对象
		Employee employee = new Employee();
		employee.setEname(addEmpForm.getEname());
		employee.setEmail(addEmpForm.getEmail());
		employee.setPassword(addEmpForm.getPassword());
		employee.setGrade(addEmpForm.getGrade());
		employee.setSalary(Float.parseFloat(addEmpForm.getSalary()));
		employee.setDepartment((Department)departmentService.findById(Department.class,Integer.parseInt(addEmpForm.getDepartment_id())));
		
		//保存雇员
		employeeService.add(employee);
		
		return mapping.findForward("addSuccess");
	}
	
	//显示雇员showEmps
	public ActionForward showEmps(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sPageNow = request.getParameter("pageNow");
		int pageNow = 1;
		if(sPageNow != null){
			pageNow = Integer.parseInt(sPageNow);
		}
		List<Employee> employeeList = employeeService.showEmps(3,pageNow);
		request.getSession().setAttribute("employeeList", employeeList);
		int pageCount = employeeService.getPageCount(3);
		request.getSession().setAttribute("pageCount", pageCount);
		return mapping.findForward("showEmps");
	}
	
	//删除雇员deleteEmp
	public ActionForward deleteEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String empId = request.getParameter("empId");
		int id = Integer.parseInt(empId);
		employeeService.deleteById(Employee.class, id);
		return mapping.findForward("addSuccess");
	}
	
	//修改雇员信息modifyEmp
	public ActionForward modifyEmpUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String empId = request.getParameter("empId");
		int id = Integer.parseInt(empId);
		Employee employee = (Employee) employeeService.findById(Employee.class, id);
		request.getSession().setAttribute("employee", employee);
		return mapping.findForward("modifyEmpUI");
	}
	
	//修改雇员信息modifyEmp
	public ActionForward modifyEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String empId = request.getParameter("eid");
		int id = Integer.parseInt(empId);
		AddEmpForm eform = (AddEmpForm) form;
		Employee employee = new Employee();
		employee.setId(id);
		employee.setEname(eform.getEname());
		employee.setEmail(eform.getEmail());
		employee.setPassword(eform.getPassword());
		employee.setGrade(eform.getGrade());
		employee.setSalary(Float.parseFloat(eform.getSalary()));
		employee.setDepartment((Department)departmentService.findById(Department.class, Integer.parseInt(eform.getDepartment_id())));
		employeeService.executeUpdate(employee);
		return mapping.findForward("addSuccess");
	}
	
	/**
	 * @param employeeService the employeeService to set
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * @param departmentService the departmentService to set
	 */
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
}
