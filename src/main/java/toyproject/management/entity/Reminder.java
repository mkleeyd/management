package toyproject.management.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Reminder {

    @Id @GeneratedValue @Column(name = "reminderId")
    private Long id;
    private String content;
    @Enumerated
    private Reminder_Check check;
    /**
     * 단방향 설계는 단순히 한쪽에만 상대 객체 필드 생성해서 한쪽에서만 참조 가능하도록 하면 그게 바로 단방향!!!!!!!!!
     *
     * 그럼 반대로, 양방향은 양쪽 다 상대 객체 필드 생성해서 양쪽 다 왔다갔다 참조 할 수 있도록 길 뚫어주면 양방향!!!!!
     *
     * 아래는 단방향도, 양방향도 아니고 단순히 리마인더 하나 추가하면 view에서 넘어온 userId값을 그대로 저장해주면 된다
     */
    private Long userId;

    //===== 연관관계 및 Setter 메서드 =====//
    public void add(String content, Reminder_Check check, Long userId){
        this.content = content;
        this.content = content;
        this.check = Reminder_Check.ON;
        this.userId = userId;
    }

}//////
