package sage.springcoder.jamhubservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class JamPagedList extends PageImpl<JamDto> {
    public JamPagedList(List<JamDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public JamPagedList(List<JamDto> content) {
        super(content);
    }
}
