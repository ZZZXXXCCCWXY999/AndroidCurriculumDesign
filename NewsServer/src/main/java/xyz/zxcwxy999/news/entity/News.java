package xyz.zxcwxy999.news.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {
    public int nid;
    public String title;
    public String message;
    public Date date;
}
