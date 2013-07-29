package jp.co.everrisesample.minimum01.dao;
import static jp.co.everrisesample.minimum01.entity.Names.student;
import static org.seasar.extension.jdbc.operation.Operations.asc;
import static org.seasar.extension.jdbc.operation.Operations.contains;
import static org.seasar.extension.jdbc.operation.Operations.eq;
import static org.seasar.extension.jdbc.operation.Operations.isNull;

import java.util.List;

import jp.co.everrisesample.minimum01.entity.Student;

import org.seasar.extension.jdbc.OrderByItem;

public class StudentDao extends AbstractDao<Student>{
	/**
	 * @author Du
	 * @param id
	 * @return student with id
	 */
	public Student findByIdSimple(Long id){
		return select().id(id).getSingleResult();
	}

	/**
	 * @author Du
	 * @param studentid
	 * @return student follow studentid
	 */
	public Student findById(Long studentid){
		return select()
				.where(
					eq(student().id(),studentid),
					isNull(student().deletedAt())
				).getSingleResult();
	}

	/**
	 * @author Du
	 * @return list Students
	 */
	public List<Student> findAllOrderById(){
		return select().orderBy(asc(student().id())).getResultList();
	}

	/**
	 * @author Du
	 * @param studentId
	 * @param studentName
	 * @param address
	 * @param email
	 * @return
	 */
	public Student update(Long studentId, String studentName, String address, String email){
		Student student = this.findById(studentId);
		student.name = studentName;
		student.address = address;
		student.email = email;
		student.setParamsForUpdate();
		this.update(student);
		return this.findById(student.id);
	}

	/**
	 * @author Du
	 * @param studentName
	 * @param address
	 * @param email
	 * @return
	 */
	public Student insert(String studentName, String address, String email){
		Student student = new Student();
		student.name = studentName;
		student.address = address;
		student.email = email;
		student.setParamsForNew();
		this.insert(student);
		return this.findById(student.id);
	}

	public List<Student> delete(Long studentId){
		Student student = this.findById(studentId);
		student.setParamsForDelete();
		this.update(student);
		return this.findAllOrderById();
	}

	/**
	 *
	 * @author Yamazaki
	 * search by studentName
	 * @param studentName
	 * @param orderByItem
	 * @param limit
	 * @param page
	 * @return
	 */
	public List<Student> findAllByNameAndPageConditions(String studentName, OrderByItem orderByItem, int limit, int page){
        return select()
                .where(
                        contains(student().name(), studentName),
                        isNull(student().deletedAt())
                )
                .orderBy(orderByItem, asc(student().id()))
                .limit(limit)
                .offset(limit * (page - 1))
                .getResultList();
    }
	public long getTotalCountByName(String studentName){
        return select()
                .where(
                        contains(student().name(), studentName),
                        isNull(student().deletedAt())
                )
                .getCount();
    }
}
