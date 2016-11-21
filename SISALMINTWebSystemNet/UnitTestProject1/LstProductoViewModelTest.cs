using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using SISALMINTWebSystemNet.ViewModel.ProductoViewModel;
using SISALMINTWebSystemNet.Models;

namespace UnitTestProject1
{
    [TestClass]
    public class LstProductoViewModelTest
    {
        [TestMethod]
        public void Fill()
        {
            LstProductoViewModel objViewModel = new LstProductoViewModel();
            objViewModel.Fill();
            Assert.AreNotEqual(0, objViewModel.LstProducto.Count);
        }

        [TestMethod]
        public void FillBuscar()
        {
            LstProductoViewModel objViewModel = new LstProductoViewModel();
            objViewModel.Filtro = "55";
            objViewModel.Fill();
            Assert.AreNotEqual(0, objViewModel.LstProducto.Count);
        }

        [TestMethod]
        public void FillBuscarFlujoAlternativo()
        {
            LstProductoViewModel objViewModel = new LstProductoViewModel();
            objViewModel.Filtro = "assa7fs89a7f";
            objViewModel.Fill();
            Assert.AreEqual(0, objViewModel.LstProducto.Count);
        }
    }
}
