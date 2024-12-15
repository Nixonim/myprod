package entity;

import lombok.Value;

import java.util.Date;

@Value
public class Company {
    int id;
    String name;
    Date date;
}
