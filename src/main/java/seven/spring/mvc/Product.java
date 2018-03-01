package seven.spring.mvc;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Product implements Serializable{
    private static final long servilVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = 10)
    private String name;

    private String description;
    private BigDecimal price;
    private List<MultipartFile> images;

    @Past
    private LocalDate priductionDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPriductionDate() {
        return priductionDate;
    }

    public void setPriductionDate(LocalDate priductionDate) {
        this.priductionDate = priductionDate;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
