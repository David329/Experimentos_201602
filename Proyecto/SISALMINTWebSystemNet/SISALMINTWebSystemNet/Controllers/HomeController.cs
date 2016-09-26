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
            LoginViewModel objViewModel = new LoginViewModel();
            return View(objViewModel);
        }
        [HttpPost]
        public ActionResult Login(LoginViewModel ObjViewModel)
        {
            try
            {
                var objAdmin = ObjViewModel.LoginAdmin(ObjViewModel.objAdmin);
                if (objAdmin != null)
                {
                    Session["objAdmin"] = objAdmin; return RedirectToAction("AdmInicio", "Admin");
                }
                return RedirectToAction("Login", "Home");
            }
            catch (Exception)
            {
                return RedirectToAction("Index", "Home");
            }
        }
    }
}