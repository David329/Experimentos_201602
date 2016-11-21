using SISALMINTWebSystemNet.ViewModel.HomeViewModel;
using SISALMINTWebSystemNet.Models;
using NUnit.Framework;
namespace UnitTestProject1
{
    [TestFixture]
    public class LoginViewModelTest
    {

        [Test]
        public void ValidarLogin()
        {
            LoginViewModel objViewModel = new LoginViewModel();
            objViewModel.objAdmin = new Admin();
            objViewModel.objAdmin.Usuario = "a";
            objViewModel.objAdmin.Passw = "a";
            Assert.AreEqual(true, objViewModel.ValidarLogin());
        }

        [Test]
        public void ValidarLoginFlujoAlternativo()
        {
            LoginViewModel objViewModel = new LoginViewModel();
            objViewModel.objAdmin = new Admin();
            objViewModel.objAdmin.Usuario = "f";
            objViewModel.objAdmin.Passw = "f";
            Assert.AreEqual(false, objViewModel.ValidarLogin());
        }

        [Test]
        public void GetAdmin()
        {
            LoginViewModel objViewModel = new LoginViewModel();
            objViewModel.objAdmin = new Admin();
            objViewModel.objAdmin.Usuario = "a";
            objViewModel.objAdmin.Passw = "a";
            Admin objAdmin = objViewModel.GetAdmin();
            Assert.IsNotNull(objAdmin);
        }

        [Test]
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
