func isAnagram(s string, t string) bool {
    	// Quick exit: tamanhos diferentes = nunca é anagrama
	if len(s) != len(t) {
		return false
	}

	// Step 1: contar frequência de cada char em s
	charCount := make(map[rune]int)
	for _, ch := range s {
		charCount[ch]++
	}

	// Step 2: decrementar conforme vê em t
	for _, ch := range t {
		if charCount[ch] == 0 {
			return false // Char não existe ou já foi zerado
		}
		charCount[ch]--
	}

	return true
}
