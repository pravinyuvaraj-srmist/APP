"""Q5: DFA that accepts binary strings ending in 01 (automata-lib)."""
from automata.fa.dfa import DFA

dfa = DFA(
    states={"q0", "q1", "q2"},
    input_symbols={"0", "1"},
    transitions={
        "q0": {"0": "q1", "1": "q0"},
        "q1": {"0": "q1", "1": "q2"},
        "q2": {"0": "q1", "1": "q0"},
    },
    initial_state="q0",
    final_states={"q2"},
)

test_strings = ["01", "101", "1101", "0", "10", "011", ""]

for value in test_strings:
    print(f"{value!r}: {'Accepted' if dfa.accepts_input(value) else 'Rejected'}")

# State meaning:
# q0: no useful trailing 0; q1: the string currently ends in 0;
# q2: the string currently ends in 01 (accepting state).
