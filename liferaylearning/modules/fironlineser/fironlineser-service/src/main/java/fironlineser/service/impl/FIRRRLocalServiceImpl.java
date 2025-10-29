/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fironlineser.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

import fironlineser.model.FIRRR;
import fironlineser.service.base.FIRRRLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=fironlineser.model.FIRRR",
	service = AopService.class
)
public class FIRRRLocalServiceImpl extends FIRRRLocalServiceBaseImpl {
	
	// Custom method to get FIRs by userId
		public List<FIRRR> getFIRsByUserId(long userId) {
			return firrrPersistence.findByUserId(userId);
		}
		
		// Custom method to create FIR with all details
		public FIRRR createFIR(
				long userId, String complainantName, Date incidentDate, 
				String incidentDetails, String incidentLocation, String status,
				String proofFileName, String proofFilePath) throws PortalException {
			
			long firId = counterLocalService.increment(FIRRR.class.getName());
			FIRRR firrr = firrrPersistence.create(firId);
			
			firrr.setUserId(userId);
			firrr.setComplainantName(complainantName);
			firrr.setIncidentDate(incidentDate);
			firrr.setIncidentDetails(incidentDetails);
			firrr.setIncidentLocation(incidentLocation);
			firrr.setStatus(status);
			firrr.setProofFileName(proofFileName);
			firrr.setProofFilePath(proofFilePath);
			firrr.setCreateDate(new Date());
			firrr.setModifiedDate(new Date());
			
			return firrrPersistence.update(firrr);
		}
}




