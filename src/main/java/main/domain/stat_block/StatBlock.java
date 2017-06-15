package main.domain.stat_block;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joel on 13.06.2017.
 */
@Entity
public class StatBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String blockname;

    @Lob
    private HashMap<String, String> valueMap;

    public String getBlockname() {
        return blockname;
    }

    public StatBlock setBlockname(String blockname) {
        this.blockname = blockname;
        return this;
    }

    public Map<String, String> getValueMap() {
        return valueMap;
    }

    public StatBlock setValueMap(HashMap<String, String> valueMap) {
        this.valueMap = valueMap;
        return this;
    }

    public StatBlock addValueToMap(String key, String value) {
        if (this.valueMap == null) {
            this.valueMap = new HashMap<>();
        }
        this.valueMap.put(key, value);
        return this;
    }

}
