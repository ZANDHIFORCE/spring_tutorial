package hello.hello_spring.domain;

public class Member {

    private Long id; //시스템이 저장하는 ID
    private String name;

    public Long getId() {
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
}
