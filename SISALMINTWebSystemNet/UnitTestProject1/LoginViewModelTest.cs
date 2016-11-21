using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using SISALMINTWebSystemNet.ViewModel.HomeViewModel;
using SISALMINTWebSystemNet.Models;

namespace UnitTestProject1
{
    [TestClass]
    public class LoginViewModelTest
    {

        [TestMethod]
        public void ValidarLogin()
        {
            LoginViewModel objViewModel = new LoginViewModel();
            objViewModel.objAdmin = new Admin();
            objViewModel.objAdmin.Usuario = "a";
            objViewModel.objAdmin.Passw = "a";
            Assert.AreEqual(true, objViewModel.ValidarLogin());
        }

        [TestMethod]
        public void ValidarLoginFlujoAlternativo()
        {
            LoginViewModel objViewModel = new LoginViewModel();
            objViewModel.objAdmin = new Admin();
            objViewModel.objAdmin.Usuario = "f";
            objViewModel.objAdmin.Passw = "f";
            Assert.AreEqual(false, objViewModel.ValidarLogin());
        }

        [TestMethod]
        public void GetAdmin()
        {
            LoginViewModel objViewModel = new LoginViewModel();
            objViewModel.objAdmin = new Admin();
            objViewModel.objAdmin.Usuario = "a";
            objViewModel.objAdmin.Passw = "a";
            Admin objAdmin = objViewModel.GetAdmin();
            Assert.IsNotNull(objAdmin);
        }

        [TestMethod]
        public void GetAdminFlujoAlternativo()
        {
            LoginViewModel objViewModel = new LoginViewModel();
            objViewModel.objAdmin = new Admin();
            objViewModel.objAdmin.Usuario = "d";
            objViewModel.objAdmin.Passw = "d";
            Admin objAdmin = objViewModel.GetAdmin();
            Assert.IsNull(objAdmin);
        }
    }
}
