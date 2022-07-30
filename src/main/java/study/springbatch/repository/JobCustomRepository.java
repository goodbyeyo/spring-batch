//package study.springbatch.repository;
//
//import lombok.RequiredArgsConstructor;
//
//import javax.sql.DataSource;
//
//@RequiredArgsConstructor
//public class JobCustomRepository {
//
//    private final DataSource dataSource;

    // JDBC
//    protected JobRepository createJobRepository() throws Exception {
//        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTransactionManager(factory.getTransactionManager());
//        factory.setIsolationLevelForCreate("ISOLATION SERIALIZABLE"); // isolation 수준, 기본값은 "ISOLATION_SERIALIZABLE"
//        factory.setTablePrefix("SYSTEM_"); // 테이블 Prefix, 기본값은 "BATCH_", BATCH_JOB_EXECUTION 가 SYSTEM_JOB_EXECUTION 으로 변경됨
//        factory.setMaxVarCharLength(1000);    // varchar 최대 길이 : 기본값 2500
//        return (JobRepository) factory.getObject(); // Proxy 객체가 생성됨 : 트랜잭션 Advice 적용 등을 위해 AOP 기술 적용
//    }

    // MEMORY
//    protected JobRepository createJobRepository() throws Exception {
//        MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean();
//        factory.setTransactionManager(factory.getTransactionManager());   // RecourcelessTransactionManager 사용
//    용   return (JobRepository) factory.getObject();
//    }


//}
