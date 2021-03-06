package baseUse.wikiData;

public class TagAltername {
	private String alternateName;

	/**
	 * u for unchanged; c for changed; n for new; d for delete;
	 */
	private char status;

	public TagAltername(String a, char s) {
		alternateName = a;
		status = s;
	}

	public String getAlternateName() {
		return alternateName;
	}

	public char getStatus() {
		return status;
	}

	public void setAlternateName(String a) {
		alternateName = a;
		status = 'c';
	}

	public void delete() {
		status = 'd';
	}
}
