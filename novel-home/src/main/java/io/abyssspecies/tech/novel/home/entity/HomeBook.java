package io.abyssspecies.tech.novel.home.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description...
 *
 * @author abyss species 2021-05
 */
@Data
public class HomeBook {
    private Long id;
    private Long bookId;
    private Byte sort;
    private Byte type;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
