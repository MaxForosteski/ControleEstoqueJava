/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author max.silva
 */
public class Produto {
    private Long Id;
    private String Name;
    private BigDecimal Price;
    private String Description;
    private boolean IsActive;
    private LocalDateTime CreatedOn;
    private LocalDateTime UpdatedOn;
    
    public Produto(Long Id, String Name, BigDecimal Price, String Description, boolean IsActive, LocalDateTime CreatedOn, LocalDateTime UpdatedOn){
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Description = Description;
        this.IsActive = IsActive;
        this.CreatedOn = CreatedOn;
        this.UpdatedOn = UpdatedOn;
    }
    
    public Long getId(){
        return Id;
    }
    
    public void setId(Long Id){
        this.Id = Id;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public BigDecimal getPrice(){
        return Price;
    }
    
    public void setPrice(BigDecimal price){
        this.Price = price;
    }
    
    public String getDescription(){
        return Description;
    }
    
    public void setDescription(String Description){
        this.Description = Description;
    }
    
    public boolean getIsActive(){
        return IsActive;
    }
    
    public void setIsActive(boolean IsActive){
        this.IsActive = IsActive;
    }
    
    public LocalDateTime getCreatedOn(){
        return CreatedOn;
    }
    
    public void setCreatedOn(LocalDateTime CreatedOn){
        this.CreatedOn = CreatedOn;
    }
    
    public LocalDateTime getUpdatedOn(){
        return UpdatedOn;
    }
    
    public void setUpdatedOn(LocalDateTime UpdatedOn){
        this.UpdatedOn = UpdatedOn;
    }
}
