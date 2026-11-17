"""Q6: NFA that accepts strings over {a,b} containing substring 'ab'."""
from automata.fa.nfa import NFA

nfa = NFA(
    states={"q0", "q1", "q2"},
    input_symbols={"a", "b"},
    transitions={
        "q0": {"a": {"q0", "q1"}, "b": {"q0"}},
        "q1": {"b": {"q2"}},
        "q2": {"a": {"q2"}, "b": {"q2"}},
    },
    initial_state="q0",
    final_states={"q2"},
)

test_strings = ["ab", "aab", "baba", "bbaab", "aaa", "bbb", "a", ""]

for value in test_strings:
    print(f"{value!r}: {'Accepted' if nfa.accepts_input(value) else 'Rejected'}")

# q0 scans any prefix; on 'a' it may also move to q1.
# q1 expects 'b'; q2 means 'ab' has been found and accepts any suffix.
