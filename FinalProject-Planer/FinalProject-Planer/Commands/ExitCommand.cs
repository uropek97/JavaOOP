using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    public class ExitCommand : PlanerCommand
    {
        private Presenter? _Presenter;

        public ExitCommand(Presenter? presenter) => _Presenter = presenter;

        public override string? Describe => "Выход из приложения.";

        public override void Execute(string[] args)
        {
            _Presenter!.Stop();
        }
    }
}
