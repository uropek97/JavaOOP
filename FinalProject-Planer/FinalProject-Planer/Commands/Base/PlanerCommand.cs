namespace FinalProject_Planer.Commands.Base
{
    public abstract class PlanerCommand
    {
        public abstract string? Describe { get; }

        public abstract void Execute(string[] args);
    }
}
