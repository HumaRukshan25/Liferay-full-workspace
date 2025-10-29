package myrest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Sania Mir
 * @generated
 */
@Generated("")
@GraphQLName(description = "Represent FIRRR entity APIs.", value = "FIRRR")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "FIRRR")
public class FIRRR implements Serializable {

	public static FIRRR toDTO(String json) {
		return ObjectMapperUtil.readValue(FIRRR.class, json);
	}

	public static FIRRR unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(FIRRR.class, json);
	}

	@Schema
	public String getAssignedInspector() {
		return assignedInspector;
	}

	public void setAssignedInspector(String assignedInspector) {
		this.assignedInspector = assignedInspector;
	}

	@JsonIgnore
	public void setAssignedInspector(
		UnsafeSupplier<String, Exception> assignedInspectorUnsafeSupplier) {

		try {
			assignedInspector = assignedInspectorUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String assignedInspector;

	@Schema
	public String getComplainantName() {
		return complainantName;
	}

	public void setComplainantName(String complainantName) {
		this.complainantName = complainantName;
	}

	@JsonIgnore
	public void setComplainantName(
		UnsafeSupplier<String, Exception> complainantNameUnsafeSupplier) {

		try {
			complainantName = complainantNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String complainantName;

	@Schema
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonIgnore
	public void setCreateDate(
		UnsafeSupplier<Date, Exception> createDateUnsafeSupplier) {

		try {
			createDate = createDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date createDate;

	@Schema
	@Valid
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@JsonIgnore
	public void setData(UnsafeSupplier<Object, Exception> dataUnsafeSupplier) {
		try {
			data = dataUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Object data;

	@Schema
	public Long getFirId() {
		return firId;
	}

	public void setFirId(Long firId) {
		this.firId = firId;
	}

	@JsonIgnore
	public void setFirId(UnsafeSupplier<Long, Exception> firIdUnsafeSupplier) {
		try {
			firId = firIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long firId;

	@Schema
	public Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}

	@JsonIgnore
	public void setIncidentDate(
		UnsafeSupplier<Date, Exception> incidentDateUnsafeSupplier) {

		try {
			incidentDate = incidentDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date incidentDate;

	@Schema
	public String getIncidentDetails() {
		return incidentDetails;
	}

	public void setIncidentDetails(String incidentDetails) {
		this.incidentDetails = incidentDetails;
	}

	@JsonIgnore
	public void setIncidentDetails(
		UnsafeSupplier<String, Exception> incidentDetailsUnsafeSupplier) {

		try {
			incidentDetails = incidentDetailsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String incidentDetails;

	@Schema
	public String getIncidentLocation() {
		return incidentLocation;
	}

	public void setIncidentLocation(String incidentLocation) {
		this.incidentLocation = incidentLocation;
	}

	@JsonIgnore
	public void setIncidentLocation(
		UnsafeSupplier<String, Exception> incidentLocationUnsafeSupplier) {

		try {
			incidentLocation = incidentLocationUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String incidentLocation;

	@Schema
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonIgnore
	public void setMessage(
		UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String message;

	@Schema
	public String getModificationDetails() {
		return modificationDetails;
	}

	public void setModificationDetails(String modificationDetails) {
		this.modificationDetails = modificationDetails;
	}

	@JsonIgnore
	public void setModificationDetails(
		UnsafeSupplier<String, Exception> modificationDetailsUnsafeSupplier) {

		try {
			modificationDetails = modificationDetailsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String modificationDetails;

	@Schema
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@JsonIgnore
	public void setModifiedDate(
		UnsafeSupplier<Date, Exception> modifiedDateUnsafeSupplier) {

		try {
			modifiedDate = modifiedDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date modifiedDate;

	@Schema
	public String getProofFileName() {
		return proofFileName;
	}

	public void setProofFileName(String proofFileName) {
		this.proofFileName = proofFileName;
	}

	@JsonIgnore
	public void setProofFileName(
		UnsafeSupplier<String, Exception> proofFileNameUnsafeSupplier) {

		try {
			proofFileName = proofFileNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String proofFileName;

	@Schema
	public String getProofFilePath() {
		return proofFilePath;
	}

	public void setProofFilePath(String proofFilePath) {
		this.proofFilePath = proofFilePath;
	}

	@JsonIgnore
	public void setProofFilePath(
		UnsafeSupplier<String, Exception> proofFilePathUnsafeSupplier) {

		try {
			proofFilePath = proofFilePathUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String proofFilePath;

	@Schema
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonIgnore
	public void setStatus(
		UnsafeSupplier<String, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String status;

	@Schema
	public String getTimeline() {
		return timeline;
	}

	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}

	@JsonIgnore
	public void setTimeline(
		UnsafeSupplier<String, Exception> timelineUnsafeSupplier) {

		try {
			timeline = timelineUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String timeline;

	@Schema
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@JsonIgnore
	public void setUserId(
		UnsafeSupplier<Long, Exception> userIdUnsafeSupplier) {

		try {
			userId = userIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long userId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FIRRR)) {
			return false;
		}

		FIRRR firrr = (FIRRR)object;

		return Objects.equals(toString(), firrr.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (assignedInspector != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"assignedInspector\": ");

			sb.append("\"");

			sb.append(_escape(assignedInspector));

			sb.append("\"");
		}

		if (complainantName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"complainantName\": ");

			sb.append("\"");

			sb.append(_escape(complainantName));

			sb.append("\"");
		}

		if (createDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(createDate));

			sb.append("\"");
		}

		if (data != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"data\": ");

			if (data instanceof Map) {
				sb.append(JSONFactoryUtil.createJSONObject((Map<?, ?>)data));
			}
			else if (data instanceof String) {
				sb.append("\"");
				sb.append(_escape((String)data));
				sb.append("\"");
			}
			else {
				sb.append(data);
			}
		}

		if (firId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firId\": ");

			sb.append(firId);
		}

		if (incidentDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"incidentDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(incidentDate));

			sb.append("\"");
		}

		if (incidentDetails != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"incidentDetails\": ");

			sb.append("\"");

			sb.append(_escape(incidentDetails));

			sb.append("\"");
		}

		if (incidentLocation != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"incidentLocation\": ");

			sb.append("\"");

			sb.append(_escape(incidentLocation));

			sb.append("\"");
		}

		if (message != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(message));

			sb.append("\"");
		}

		if (modificationDetails != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modificationDetails\": ");

			sb.append("\"");

			sb.append(_escape(modificationDetails));

			sb.append("\"");
		}

		if (modifiedDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(modifiedDate));

			sb.append("\"");
		}

		if (proofFileName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"proofFileName\": ");

			sb.append("\"");

			sb.append(_escape(proofFileName));

			sb.append("\"");
		}

		if (proofFilePath != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"proofFilePath\": ");

			sb.append("\"");

			sb.append(_escape(proofFilePath));

			sb.append("\"");
		}

		if (status != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(status));

			sb.append("\"");
		}

		if (timeline != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"timeline\": ");

			sb.append("\"");

			sb.append(_escape(timeline));

			sb.append("\"");
		}

		if (userId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(userId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "myrest.dto.v1_0.FIRRR", name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}