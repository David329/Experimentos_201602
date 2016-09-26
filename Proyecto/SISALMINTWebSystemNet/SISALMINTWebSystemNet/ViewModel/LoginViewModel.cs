using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SISALMINTWebSystemNet.Model;
namespace SISALMINTWebSystemNet.ViewModel
{
    public class LoginViewModel
    {
        private DBSISALMINTEntities context;
        public Admin objAdmin;
        public Admin LoginAdmin(Admin obj)
        {
            obj = context.Admin.FirstOrDefault(x => x.User == obj.User && x.Password == obj.Password);
            return obj;
       }
    }
}