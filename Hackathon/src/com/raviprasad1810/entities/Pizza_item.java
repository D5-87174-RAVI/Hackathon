package com.raviprasad1810.entities;

public class Pizza_item {
int id;
String name;
String type;
String category;
String description;

public Pizza_item() {

}

public Pizza_item(int id, String name, String type, String category, String description) {
super();
this.id = id;
this.name = name;
this.type = type;
this.category = category;
this.description = description;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getCategory() {
return category;
}

public void setCategory(String category) {
this.category = category;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

@Override
public String toString() {
return "Pizza_item [id=" + id + ", name=" + name + ", type=" + type + ", category=" + category
+ ", description=" + description + "]";
}


}