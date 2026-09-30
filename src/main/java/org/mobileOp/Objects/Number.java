package org.mobileOp.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mobileOp.enums.Status;
import org.mobileOp.enums.NumberType;

@Entity
@Table(name = "numbers")
@Data
@NoArgsConstructor
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "status")
    private Status status;

    @Column(name = "number_type")
    private NumberType numberType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    public Number(String number, Status status, NumberType numberType) {
        this.number = number;
        this.status = status;
        this.numberType = numberType;
        this.plan = null;
    }

    @Override
    public String toString(){
        return "Number: " + number + ", Status: " + status + ", Type: " + numberType;
    }
}
