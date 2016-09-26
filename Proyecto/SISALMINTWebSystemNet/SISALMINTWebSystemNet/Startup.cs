using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(SISALMINTWebSystemNet.Startup))]
namespace SISALMINTWebSystemNet
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
