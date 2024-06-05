package idusw.springboot.egymall.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class BlogEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // MySQL, MariaDB의 경우 자동증가하는 필드 IDENTITY, Oracle의 경우 SEQUENCE, AUTO 유동적 선택
    private Long bno;
    @Column(length = 40, nullable = false)
    private String title;
    @Column(length = 200, nullable = false) // nullable = false 경우는 null 넣으면 오류 발생
    private String content;
    @Column
    private Long views;
    @Column(length = 20)
    private String block;
    // Association
    @ManyToOne(fetch = FetchType.LAZY) // 1 Blogger(Member)가 여러개의 블로그를 작성할 수 있는 관계
    private MemberEntity writer;
}