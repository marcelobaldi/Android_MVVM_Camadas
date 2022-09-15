package mb.livedatabase1;
import java.io.Serializable;

public class DogModel implements Serializable {
    //Atributos
    private int     id;
    private String  nome;
    private Integer image;

    //Construtor (Vazio, SemId, ComId, Etc)
    public DogModel() { }
    public DogModel(String nome, Integer image) { this.nome = nome; this.image = image; }
    public DogModel(int id, String nome, Integer image){this.id=id;this.nome=nome;this.image=image;}

    //GettSetter
    public int getId()                  { return id;          }
    public void setId(int id)           { this.id = id;       }
    public String getNome()             { return nome;        }
    public void setNome(String nome)    { this.nome = nome;   }
    public Integer getImage()           { return image;       }
    public void setImage(Integer image) { this.image = image; }

    //ToString (Debugar)
    @Override public String toString(){return "{"+"id="+id+",nome='"+nome+'\''+",image="+image+'}';}
}


