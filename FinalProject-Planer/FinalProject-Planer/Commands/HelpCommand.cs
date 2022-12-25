using FinalProject_Planer.Commands.Base;

namespace FinalProject_Planer.Commands
{
    public class HelpCommand : PlanerCommand
    {
        private readonly IUserInterface? _UserInterface;
        private readonly Presenter? _Presenter;

        public HelpCommand(IUserInterface? userInterface, Presenter? presenter)
        {
            _UserInterface = userInterface;
            _Presenter = presenter;
        }

        public override string? Describe => "Выводит список команд";

        public override void Execute(string[] args)
        {
            _UserInterface!.printMessage("Планер поддерживает следующие команды: ", true);

            foreach(var (name, command) in _Presenter!.Commands!)
            {
                _UserInterface!.printMessage($"     {name.PadRight(12, '-')}{command.Describe}", true);
            }
        }
    }
}
