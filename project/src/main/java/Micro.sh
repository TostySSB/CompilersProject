OUTPUT=$(java Main "$1".micro 2>&1)
if [[ -n "$OUTPUT" ]]; then
    echo "Not accepted"
    echo ""
else
    echo "Accepted"
    echo ""
fi