-- This is a very abbreviated seed. Will vastly expand it later, but wanted to test with just a few schools.
DELETE FROM schools;

INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Ambler Primary School and Children''s Centre',
    'Blackstock Road, N4 2DR',
    -0.101753,
    51.5625992,
    '[{"year": "''24-''25", "radius": 0.290}, {"year": "''23-''24", "radius": 0.393}, {"year": "''22-''23", "radius": 0.289}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50215756',
    'primary',
    'mixed',
    'n/a',
    'community',
    'www.amblerprimaryschool.co.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Gillespie Primary School',
    'Gillespie Road, N5 1LH',
    -0.10007,
    51.5600014,
    '[{"year": "''24-''25", "radius": 0.148}, {"year": "''23-''24", "radius": 0.148}, {"year": "''22-''23", "radius": 0.141}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50235575',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.gillespie.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St John''s Highbury Vale CofE Primary School',
    'Conewood Street, N5 1DL',
    -0.10078,
    51.5582008,
    '[{"year": "''24-''25", "radius": 0.351}, {"year": "''23-''24", "radius": 0.21}, {"year": "''22-''23", "radius": 0.28}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50232508',
    'primary',
    'mixed',
    'n/a',
    'coe',
    'https://www.stjohnevangelist.co.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St Joan of Arc RC Primary School',
    'Northolme Road, N5 2UX',
    -0.0970096,
    51.5565987,
    '[{"year": "''24-''25", "radius": 0.55}, {"year": "''23-''24", "radius": 0.33}, {"year": "''22-''23", "radius": 0.2}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50241024',
    'primary',
    'mixed',
    'n/a',
    'catholic',
    'https://www.st-joanofarc.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Highbury Quadrant Primary School',
    'Highbury New Park, N5 2DP',
    -0.0918841,
    51.5540009,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}]',
    2,
    'https://files.ofsted.gov.uk/v1/file/50228420',
    'primary',
    'mixed',
    'n/a',
    'community',
    'www.highburyquadrantprimary.co.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Elizabeth Garrett Anderson School',
    'Donegal Street, N1 9QG',
    -0.112659,
    51.5330009,
    '[{"year": "''24-''25", "radius": 1.082}, {"year": "''23-''24", "radius": 1.506}, {"year": "''22-''23", "radius": 0.873}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/2447618',
    'secondary',
    'girls',
    'n/a',
    'community',
    'https://www.egaschool.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Betty Layward Primary School',
    'Clissold Road, N16 9EX',
    -0.0846212,
    51.5578995,
    '[{"year": "''24-''25", "radius": 0.305}, {"year": "''23-''24", "radius": 0.339}, {"year": "''22-''23", "radius": 0.38}, {"year": "''21-''22", "radius": 0.381}, {"year": "''20-''21", "radius": 0.352}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50233922',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.bettylayward.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Grasmere Primary School',
    '92 Albion Road, N16 9PD',
    -0.0835736,
    51.5550003,
    '[{"year": "''24-''25", "radius": 0.331}, {"year": "''23-''24", "radius": 0.297}, {"year": "''22-''23", "radius": 0.417}, {"year": "''21-''22", "radius": 0.38}, {"year": "''20-''21", "radius": 0.3}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50183475',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.grasmere.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Grazebrook Primary School',
    'Lordship Road, N16 0QP',
    -0.0831442,
    51.5642014,
    '[{"year": "''24-''25", "radius": 0.439}, {"year": "''23-''24", "radius": 0.283}, {"year": "''22-''23", "radius": 0.557}, {"year": "''21-''22", "radius": 0.599}, {"year": "''20-''21", "radius": 0.41}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50235291',
    'primary',
    'mixed',
    'n/a',
    'community',
    'http://www.grazebrook.hackney.sch.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St. Mary''s Church of England Primary School',
    'Barn Street, N16 0JT',
    -0.0815231,
    51.5623016,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}, {"year": "''21-''22", "radius": -1}, {"year": "''20-''21", "radius": -1}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50220293',
    'primary',
    'mixed',
    'n/a',
    'coe',
    'https://st-marys.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'William Patten Primary School',
    'Stoke Newington Church Street, N16 0NX',
    -0.0749634,
    51.5617981,
    '[{"year": "''24-''25", "radius": 0.422}, {"year": "''23-''24", "radius": 0.365}, {"year": "''22-''23", "radius": 0.207}, {"year": "''21-''22", "radius": 0.475}, {"year": "''20-''21", "radius": 0.227}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50233486',
    'primary',
    'mixed',
    'n/a',
    'community',
    'http://www.williampatten.hackney.sch.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Drayton Park Primary School',
    'Arvon Road, N5 1PJ',
    -0.105745,
    51.5516014,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": 0.479}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50134753',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.draytonpark.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Pakeman Primary School',
    'Hornsey Road, N7 6DU',
    -0.114027,
    51.5587997,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50178850',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.pakemanprimary.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Newington Green Primary School',
    'Matthias Road, N16 8NP',
    -0.0834239,
    51.5513992,
    '[{"year": "''24-''25", "radius": 0.431}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50256887',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.newingtongreen.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Canonbury Primary School',
    'Canonbury Road, N1 2UT',
    -0.100568,
    51.544899,
    '[{"year": "''24-''25", "radius": 0.655}, {"year": "''23-''24", "radius": 0.452}, {"year": "''22-''23", "radius": 0.622}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50201204',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://canonburyprimaryschool.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Parkwood Primary School',
    'Queen''s Drive, N4 2HQ',
    -0.0993251,
    51.5651016,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": 0.94}, {"year": "''22-''23", "radius": -1}, {"year": "''21-''22", "radius": 0.287}, {"year": "''20-''21", "radius": 0.311}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50253328',
    'primary',
    'mixed',
    'n/a',
    'community',
    'http://www.parkwood.hackney.sch.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Sir Thomas Abney Primary School',
    'Fairholt Road, N16 5ED',
    -0.0820873,
    51.5704994,
    '[{"year": "''24-''25", "radius": 2.207}, {"year": "''23-''24", "radius": 1.08}, {"year": "''22-''23", "radius": -1}, {"year": "''21-''22", "radius": -1}, {"year": "''20-''21", "radius": -1}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50093859',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.sirthomasabney.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St Matthias CofE Primary School',
    'Wordsworth Road, N16 8DD',
    -0.0793649,
    51.5528984,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}, {"year": "''21-''22", "radius": -1}, {"year": "''20-''21", "radius": -1}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50224899',
    'primary',
    'mixed',
    'n/a',
    'coe',
    'https://www.st-matthias.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Stoke Newington School and Sixth Form',
    'Clissold Road, N16 9EX',
    -0.0846212,
    51.5578995,
    '[{"year": "''24-''25", "radius": 0.797}, {"year": "''23-''24", "radius": 0.911}, {"year": "''22-''23", "radius": 0.9}, {"year": "''21-''22", "radius": 0.603}, {"year": "''20-''21", "radius": 0.747}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50192955',
    'secondary',
    'mixed',
    'n/a',
    'community',
    'http://www.stokenewingtonschool.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Highbury Fields School',
    'Highbury Hill, N5 1AR',
    -0.101539,
    51.5527992,
    '[{"year": "''24-''25", "radius": 0.974}, {"year": "''23-''24", "radius": 0.787}, {"year": "''22-''23", "radius": 0.893}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50198766',
    'secondary',
    'girls',
    'n/a',
    'community',
    'http://www.highburyfields.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'City of London Academy, Highbury Grove',
    '8 Highbury Grove, N5 2EQ',
    -0.098090,
    51.550240,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": 2.167}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50186308',
    'secondary',
    'mixed',
    'n/a',
    'community',
    'https://www.highburygrove.cola.org.uk/');