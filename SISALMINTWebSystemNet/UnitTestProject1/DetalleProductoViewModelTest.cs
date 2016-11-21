using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using SISALMINTWebSystemNet.ViewModel.ProductoViewModel;
using SISALMINTWebSystemNet.Models;

namespace UnitTestProject1
{
    [TestClass]
    public class DetalleProductoViewModelTest
    {
        [TestMethod]
        public void Fill()
        {
            DetalleProductoViewModel objViewModel = new DetalleProductoViewModel();
            objViewModel.Fill("P01231");

            Assert.IsNotNull(objViewModel.objProducto);
        }

        [TestMethod]
        public void FillFlujoAlternativo()
        {
            DetalleProductoViewModel objViewModel = new DetalleProductoViewModel();
            objViewModel.Fill("dfsdf");

            Assert.IsNull(objViewModel.objProducto);
        }
    }
}
