package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    private int page; // 페이지 번호
    private int amount; // 페이지당 계시물 수

    private String criteria;
    private String keyword;

    public SearchDto(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }

}
