using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SISALMINTWebSystemNet.ViewModel;
namespace SISALMINTWebSystemNet.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
        [HttpPost]
        public ActionResult Login(LoginViewModel ObjViewModel)
        {
            return null;
            //try
            //{
            //    var objEnterprise = ObjViewModel.LoginEnterprise(ObjViewModel.ObjEnterprise);
            //    var objAdmin = ObjViewModel.LoginAdmin(ObjViewModel.ObjEnterprise);
            //    if (objEnterprise != null)
            //    {
            //        Session["objEnterprise"] = objEnterprise; return RedirectToAction("EntInicio", "Enterprise");
            //    }
            //    else if (objAdmin != null)
            //    {
            //        Session["objAdmin"] = objAdmin; return RedirectToAction("AdmInicio", "Admin");
            //    }
            //    return RedirectToAction("Login", "Home");
            //}
            //catch (Exception)
            //{
            //    return RedirectToAction("Login", "Home");
            //}
        }
    }
}