package gb.hw.tamily_tree;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable,String filePath);
    Object read(String filePath);
}
