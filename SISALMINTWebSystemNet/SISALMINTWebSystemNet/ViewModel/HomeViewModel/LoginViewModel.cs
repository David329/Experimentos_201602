using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SISALMINTWebSystemNet.Models;

namespace SISALMINTWebSystemNet.ViewModel.HomeViewModel
{
    public class LoginViewModel
    {
        public Admin objAdmin { get; set; }

        public LoginViewModel() { }

        public bool ValidarLogin()
        {
            DBSISALMINTEntities context = new DBSISALMINTEntities();
            if (context.Admin.FirstOrDefault(x => x.Usuario == objAdmin.Usuario && x.Passw == objAdmin.Passw) != null) return true;

            return false;
        }

        public Admin GetAdmin()
        {
            DBSISALMINTEntities context = new DBSISALMINTEntities();
            return context.Admin.FirstOrDefault(x => x.Usuario == objAdmin.Usuario && x.Passw == objAdmin.Passw);
        }
    }
}