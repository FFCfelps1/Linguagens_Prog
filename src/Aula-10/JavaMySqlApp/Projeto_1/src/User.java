

public final class User
{   private String  sUser;
    private String  sPass;
    
    public  User()
    {   clearObject();
    }
    public  User(String sI, String sU, String sP)
    {   sUser = sU;
        sPass = sP;
    }
    
    public  String  getUser()
    {   return  sUser;
    }
    public  void    setUser(String sU)
    {   sUser = sU;
    }
    
    public  String  getPass()
    {   return  sPass;
    }
    public  void    setPass(String sP)
    {   sPass = sP;
    }
    public  void    clearObject()
    {   sUser = "Não há usuário cadastrado";
        sPass = "Não há senha cadastrada";
    }
}
