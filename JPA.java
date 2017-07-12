/**hibernate与JPA*/
//JPA的诞生是为了整合第三方ORM框架，建立一种标准的方式，hibernata和JPA整合的良好，hibernate实现了JPA接口。
//详解JPA与hibernate的关系？
//spring-data-jpa：由于spring整合第三方的框架很强，自然也整合了持久化这方面，于是有了spring-data-jpa,包括spring-data-mongodb、spring-data-redis, 而spring-data-jpa表示与jpa的整合。
//spring-data-jpa在常用的CRUD(create,retrieve,update,delete)场景中，几乎不需要写一条SQL语句，同时它也提供了自己写sql的方式。
//repository(资源库):通过用来访问领域对象的衣柜类似集合的接口，相当于DAO，
public interface Repository<T, ID extends Serializable> {

}
//数据持久化框架：原生的hibernate中叫做session,JPA中叫做EntityManager,Mybatis中叫做sqlSession
//spring-dat-jpa 底层是用entityManager做CRUD的
//规范是epository和RepositoryImpl文件放在同一个包下面
//实现动态查询的方法有两种，最好用接口的方式（因为有类型检查，更加安全）
   T findOne(Specification<T> spec);

    List<T> findAll(Specification<T> spec);

    Page<T> findAll(Specification<T> spec, Pageable pageable);

    List<T> findAll(Specification<T> spec, Sort sort);

    long count(Specification<T> spec);//传一个接口

//动态查询
	Page<ClientException> pageException = clientExceptionRepository.findAll(new Specification<ClientException>() {
				@Override
				public Predicate toPredicate(Root<ClientException> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					 if(StringUtils.isNotBlank(clientException.getAppName()) && !"-1".equals(clientException.getAppName())){
						 list.add(cb.equal(root.get("appName").as(String.class), clientException.getAppName()));
					 }
					 if(StringUtils.isNotBlank(clientException.getAppChannel()) && !"-1".equals(clientException.getAppChannel())){
						 list.add(cb.equal(root.get("appChannel").as(String.class), clientException.getAppChannel()));
					 }
					 if(StringUtils.isNotBlank(clientException.getVersionCode()) && !"-1".equals(clientException.getVersionCode())){
						 list.add(cb.equal(root.get("versionCode").as(String.class), clientException.getVersionCode()));
					 }
					 if(StringUtils.isNotBlank(clientException.getOsName()) && !"-1".equals(clientException.getOsName())){
						 list.add(cb.equal(root.get("osName").as(String.class), clientException.getOsName()));
					 }
					Predicate[] p = new Predicate[list.size()];
					return cb.and(list.toArray(p));
				}
			}, new PageRequest(curPage-1, pageSize));

//predicate是判断的意思，放在sql中就是where后面的东西
//studentRepository.findAll(一个接口Specification<T> spec, Pageable pageable)传了一个接口，使用了策略模式？
//jpa的单个查询如果为空的话会报异常?findone();
//jpa 原生的动态查询方式，过程大致是:创建builder =>创建query => 构造条件 =>查询，除了第三步不一样，其他几部都是一抹一样的，不使用spring-data-jpa的情况下，我们要么4步骤写完，要不自己写个工具类，这里spring-data-jpa帮我们完成了这样一个动作
//JPQL写法：最后还有一个小问题，我们上面说了使用动态查询和JPQL两种方式都可以，在我们使用JPQL的时候，他的语法和常规的sql有点不太一样，以Student、Clazz关系为例，比如：

select * from student t left join clazz tt on t.clazz_id = tt.id
//这是一个很常规的sql，但是JPQL是这么写：

select t from Student t left join t.clazz tt