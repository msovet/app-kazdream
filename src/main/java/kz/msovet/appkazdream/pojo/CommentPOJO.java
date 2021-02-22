package kz.msovet.appkazdream.pojo;

import kz.msovet.appkazdream.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author merey
 *
 * POJO for {@link Comment}
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentPOJO {
    private String text;
    private Long newsId;

}
