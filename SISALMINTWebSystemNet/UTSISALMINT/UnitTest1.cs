using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using SISALMINTWebSystemNet.ViewModel.HomeViewModel;
namespace UTSISALMINT
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            try
            {
                LoginViewModel lvm = new LoginViewModel();
                lvm.objAdmin = new SISALMINTWebSystemNet.Models.Admin();
                lvm.objAdmin.Usuario = "a";
                lvm.objAdmin.Passw = "a";
                bool logeo = lvm.ValidarLogin();
                Assert.IsTrue(logeo);
            }
            catch (Exception)
            {
                throw;
            }
        }
    }
}