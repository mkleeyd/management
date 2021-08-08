package toyproject.management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Child {

    @Id @GeneratedValue @Column(name = "child_id")
    private Long id;
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    private void setParent(Parent parent){
        this.parent = parent;   // 이렇게 넣으면 @JoinColumn 으로 인해서 해당 키값 저장되어야 하는거 아님?
//        parent.getChild(this)   // 만약 양방향이라면 이렇게 해서 반대쪽에도 값 채워줘야 함
    }

    public void createChild(String username, Parent parent){
        this.username = username;
        this.setParent(parent);
    }



}/////
