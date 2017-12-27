package ru.nenahov.simplerest.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataDTO {

    @Id
    @GeneratedValue
    private Long id;

    private String data;

    private static final String TEMPLATE_DATA_TO_STRING = "ID:%s, DATA:%s";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataDTO data = (DataDTO) o;

        if (!id.equals(data.id)) return false;
        return this.data.equals(data.data);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }

    @Override
    public String toString() {
        if (data == null) return "Empty data";
        return String.format(TEMPLATE_DATA_TO_STRING, id, data);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
