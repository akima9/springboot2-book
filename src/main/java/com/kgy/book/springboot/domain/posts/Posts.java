package com.kgy.book.springboot.domain.posts;

import com.kgy.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
//@NoArgsConstructor : 기본 생성자 자동 추가
@NoArgsConstructor
//@Entity : 테이블과 링크될 클래스임을 나타냄, 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭함
@Entity
//Posts 클래스는 실제 DB 의 테이블과 매칭될 클래스
public class Posts extends BaseTimeEntity {
    //@Id : 해당 테이블의 PK 필드를 나타냄
    @Id
    //@GeneratedValue : PK 의 생성 규칙을 나타냄, 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만
    //auto_increment 가 됨
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column : 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //@Builder : 해당 클래스의 빌더 패턴 클래스를 생성
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
