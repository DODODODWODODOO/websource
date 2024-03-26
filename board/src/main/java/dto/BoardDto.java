package dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int bno;
    private String name;
    private String password;
    private String title;
    private String content;
    private String attach;
    private int reRef;
    private int reLev;
    private int reSeq;
    private int readCount;
    private Date regDate;

}
