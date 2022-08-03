package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        /**
         * 엔티티 매니저 팩토리는 하나만 생성해서
         * 애플리케이션 전체에서 공유
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        /**
         * JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
         */
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            /**
             * 회원등록
             * Member member = new Member();
             * member.setId(1L);
             * member.setName("hello");
             * em.persist(member);
             */

            /**
             * 회원검색
             * Member findMember = em.find(Member.class, 1L);
             */

            /**
             * 회원삭제
             * em.remove(1L);
             */

            /**
             * 회원 수정
             * persist()를 할 필요가 없다. JPA가 다른걸 스스로 체크하고 관리해줌
             * Member findMember = em.find(Member.class, 1L);
             * findMember.setName("hello1");
             */

            /**
             * JPQL소개
             * 객체를 대상으로 Query를 만듬
             *
             * 모든 회원을 조회할때
             *  List<Member> result = em.createQuery("select m from Member as m", Member.class)
             *                     .getResultList();
             * for(Member member : result){
             *      System.out.println("member.getName() = " + member.getName());
             * }
             */

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            System.out.println("e = " + e);
        }finally {
            em.close();
        }

        emf.close();

    }
}
