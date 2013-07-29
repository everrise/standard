package jp.co.everrisesample.minimum01.service;

import java.util.List;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.dao.StudentDao;
import jp.co.everrisesample.minimum01.dto.ListForPageDto;
import jp.co.everrisesample.minimum01.entity.Student;

import org.seasar.extension.jdbc.OrderByItem;

public class StudentService extends AbstractService{
	@Resource
	public StudentDao studentDao;

	/**
	 *@author Du
	 * @param studentName
	 * @param birthday
	 * @param email
	 * @return
	 */
	public Student createStudent(String studentName, String birthday, String email){
		return studentDao.insert(studentName, birthday, email);
	}

	/**
	 * @author Du
	 * @param studentId
	 * @param studentName
	 * @param birthday
	 * @param email
	 * @return
	 */
	public Student updateStudent(Long studentId, String studentName, String birthday, String email){
		return studentDao.update(studentId, studentName, birthday, email);
	}

	public List<Student> deleteStudent(Long studentId){
		return studentDao.delete(studentId);
	}

	/**
	 * @author Du
	 * @param studentName
	 * @param orderByItem
	 * @param limit
	 * @param page
	 * @return
	 */
	public ListForPageDto<Student> searchByNameAndPageConditions(String studentName, OrderByItem orderByItem, int limit, int page){
        ListForPageDto<Student> pageData = new ListForPageDto<Student>();
        pageData.resultList = studentDao.findAllByNameAndPageConditions(studentName, orderByItem, limit, page);
        pageData.total = studentDao.getTotalCountByName(studentName);
        pageData.page = page;
        pageData.limit = limit;
        return pageData;
    }
}
